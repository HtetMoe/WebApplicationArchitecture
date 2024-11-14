import React, { useEffect } from 'react'
import { useState, useRef } from 'react';
import Post from './Post/Post';
import PostDetails from './Post/PostDetails';
import axios from 'axios';
import { usePost } from './PostContext'; 

const Dashboard = () => {
  const { selectedPostId, setSelectedPostId } = usePost(); // access to context

  const [posts, setPosts] = useState([])
  const [selectedPost, setSelectedPost] = useState(null);
  const [isEditing, setIsEditing] = useState(false);
  
  // const [newTitle, setNewTitle] = useState("");
  // const [newAuthor, setNewAuthor] = useState("");

  //useRef()
  const titleRef = useRef();
  const authorRef = useRef();

  //fetch posts when the component mounts
  useEffect(() => {
    axios.get('http://localhost:8080/api/v1/posts')
      .then(response => setPosts(response.data))
      .catch(error => console.error('Failed fetching posts', error))
  }, [])

  //delete a post
  const deletePost = () => {
    console.log("id", selectedPostId)
    if (selectedPostId) {
      console.log("Deleting post with ID:", selectedPostId);
      axios.delete(`http://localhost:8080/api/v1/posts/${selectedPostId}`)
        .then(() => {
          setPosts(posts.filter(post => post.id !== selectedPostId)); // Remove post from state
          setSelectedPost(null)
        })
        .catch(error => {
          console.error("Error deleting post:", error);
        });
    }
  }

  //update a post
  const updatePost = () => {
    const updatedPost = { id: selectedPost.id, title: titleRef.current.value, author: authorRef.current.value };
    axios.put(`http://localhost:8080/api/v1/posts/${selectedPost.id}`, updatedPost)
      .then(response => {
        console.log("resp ", response.data)
        const updatedPosts = posts.map(post =>
          post.id === selectedPost.id ? response.data : post
        );
        setPosts(updatedPosts);

        // reset
        setSelectedPost(null);
        titleRef.current.value = "";
        authorRef.current.value = "";
        setIsEditing(false);
      })
      .catch(error => console.error("Error updating post:", error));
  }

  //add a new post
  const addPost = () => {
    const newPost = { title: titleRef.current.value, author: authorRef.current.value };
    axios.post('http://localhost:8080/api/v1/posts', newPost)
      .then(response => {
        setPosts([...posts, response.data]);

        // Reset form
        titleRef.current.value = "";
        authorRef.current.value = "";
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

  const handleSelectPost = (post) => {
    setSelectedPost(post);  // Set the selected post in the state
    setSelectedPostId(post.id)
  };

  return (
    <div>
      <h1>Dashboard</h1>

      {/* Post List */}
      <div style={{ display: "flex" }}>
        {posts.map(post => (
          <Post key={post.id} post={post} onClick={() => handleSelectPost(post)} />
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
          <input ref={titleRef} placeholder='New Title' />
          <input ref={authorRef} placeholder='New Author' />
          <button type="submit">{isEditing ? "Update" : "Add"}</button>
        </form>
      </div>
    </div>
  )
}

export default Dashboard