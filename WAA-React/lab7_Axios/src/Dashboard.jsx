import React, { useEffect } from 'react'
import { useState } from 'react';
import Post from './Post/Post';
import PostDetails from './Post/PostDetails';
import axios from 'axios';

const Dashboard = () => {
  const [posts, setPosts] = useState([])
  const [selectedPost, setSelectedPost] = useState(null);
  const [isEditing, setIsEditing] = useState(false);
  const [newTitle, setNewTitle] = useState("");
  const [newAuthor, setNewAuthor] = useState("");

  //fetch posts when the component mounts
  useEffect(() => {
    axios.get('http://localhost:8080/api/v1/posts')
      .then(response => setPosts(response.data))
      .catch(error => console.error('Failed fetching posts', error))
  }, [])

  //delete a post
  const deletePost = () => {
    if (selectedPost?.id) {
      var id = selectedPost.id
      console.log("Deleting post with ID:", id);
      axios.delete(`http://localhost:8080/api/v1/posts/${id}`)
        .then(() => {
          setPosts(posts.filter(post => post.id !== id)); // Remove post from state
          setSelectedPost(null)
        })
        .catch(error => {
          console.error("Error deleting post:", error);
        });
    }
  }

  //update a post
  const updatePost = () => {
    const updatedPost = { id: selectedPost.id, title: newTitle, author: newAuthor };
    axios.put(`http://localhost:8080/api/v1/posts/${selectedPost.id}`, updatedPost)
      .then(response => {
        console.log("resp ", response.data)
        const updatedPosts = posts.map(post =>
          post.id === selectedPost.id ? response.data : post
        );
        setPosts(updatedPosts);

        // reset
        setSelectedPost(null);
        setNewTitle("");
        setNewAuthor("");
        setIsEditing(false);
      })
      .catch(error => console.error("Error updating post:", error));
  }

  //add a new post
  const addPost = () => {
    const newPost = { title: newTitle, author: newAuthor };
    axios.post('http://localhost:8080/api/v1/posts', newPost)
      .then(response => {
        setPosts([...posts, response.data]);

        // Reset form
        setNewTitle("");
        setNewAuthor("");
      })
      .catch(error => console.error("Error adding post:", error));
  }

  //edit or add
  const handleSubmit = (e) => {
    e.preventDefault();
    if (isEditing) {
      updatePost();
    } else {
      console.log('process add post')
      addPost();
    }
  };

  return (
    <div>
      <h1>Dashboard</h1>

      {/* Post List */}
      <div style={{ display: "flex" }}>
        {posts.map(post => (
          <Post key={post.id} post={post} onClick={() => setSelectedPost(post)} />
        ))}
      </div>

      {/* Post Detail */}
      {selectedPost && !isEditing &&
        <PostDetails post={selectedPost} onEdit={() => setIsEditing(true)} onDelete={deletePost} />
      }

      {/* Add or Edit Post */}
      <div>
        <h3>{isEditing ? `Edit Post: ${selectedPost?.id}` : "Add New Post"}</h3>

        <form onSubmit={handleSubmit}>
          <input type="text" value={newTitle} onChange={(event) => setNewTitle(event.target.value)} placeholder='new title' />
          <input type="text" value={newAuthor} onChange={(event) => setNewAuthor(event.target.value)} placeholder='new author' />
          <button type="submit">{isEditing ? "Update" : "Add"}</button>
        </form>
      </div>
    </div>
  )
}

export default Dashboard