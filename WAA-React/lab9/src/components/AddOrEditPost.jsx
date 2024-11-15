import React from 'react'
import { useState, useRef, useEffect } from 'react';
import axios from 'axios';
import { useParams, useNavigate } from 'react-router-dom';

export const AddOrEditPost = () => {
  const { id } = useParams();  // get post id from param to edit post
  const navigate = useNavigate(); // to navigate back

  const [isEditing, setIsEditing] = useState(false);
  const [title, setTitle] = useState('');
  const [author, setAuthor] = useState('');

  useEffect(() => {
    if (id) {
      setIsEditing(true);
      axios.get(`http://localhost:8080/api/v1/posts/${id}`)
        .then(response => {
          setTitle(response.data.title);
          setAuthor(response.data.author);
        })
        .catch(error => console.error("Error fetching post data:", error));
    }
  }, [id]);

  const handleSubmit = (e) => {
    e.preventDefault();
    const postData = { id, title, author };

    if (isEditing) {
      axios.put(`http://localhost:8080/api/v1/posts/${id}`, postData)
        .then(() => {
          //alert("Post updated successfully!");
          navigate('/posts');
        })
        .catch(error => console.error("Error updating post:", error));
    }
    else {
      axios.post('http://localhost:8080/api/v1/posts', postData)
        .then(() => {
          //alert("Post added successfully!");
          navigate('/posts');
        })
        .catch(error => console.error("Error adding post:", error));
    }
  }

  return (
    <div>
      <h3>{isEditing ? 'Edit Post' : 'Add New Post'}</h3>
      <form onSubmit={handleSubmit}>
        <input type="text" value={title} onChange={(e) => setTitle(e.target.value)} placeholder="Title" />
        <input type="text" value={author} onChange={(e) => setAuthor(e.target.value)} placeholder="Author" />
        <button type="submit">{isEditing ? "Update" : "Add"}</button>
      </form>
    </div>
  )
}
