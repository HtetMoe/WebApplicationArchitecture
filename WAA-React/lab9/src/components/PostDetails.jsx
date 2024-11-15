import React from 'react'
import { useParams, useNavigate } from 'react-router-dom'
import { useEffect, useState } from 'react';
import axios from 'axios';

export const PostDetails = ({ onEdit, onDelete }) => {
  const { id } = useParams();  // get postId from url
  const navigate = useNavigate(); // to navigate back

  const [post, setPost] = useState(null);

  //fetch post details when the component mounts
  useEffect(() => {
    axios.get(`http://localhost:8080/api/v1/posts/${id}`)
      .then(response => setPost(response.data))
      .catch(error => console.error("Error fetching post details:", error));
  }, [id]);


  if (!post) return <div>Loading...</div>;

  const handleDelete = () => {
    axios.delete(`http://localhost:8080/api/v1/posts/${id}`)
      .then(() => {
        alert("Post deleted successfully!");
        navigate('/posts');  // redirect back to posts page
      })
      .catch(error => console.error("Error deleting post:", error));
  };

  const handleEdit = () => {
    navigate(`/edit/${id}`);  // edit 
  };

  return (
    <div style={{ margin: "10px", padding: "10px" }}>
      <h3>PostDetails</h3>
      <p>Title : {post.title} </p>
      <p>Title : {post.author} </p>
      <button onClick={handleEdit} style={{ marginRight: "10px" }}>Edit</button>
      <button onClick={handleDelete}>Delete</button>
    </div>
  )
}
