import React, { useEffect } from 'react'
import { useState } from 'react';
import Post from './Post/Post';
import PostDetails from './Post/PostDetails';

const Dashboard = () => {
    
  const [posts, setPosts] = useState([
        { id: 111, title: 'Happiness', author: 'John'},
        { id: 112, title: 'MIU', author: 'Dean'},
        { id: 113, title: 'Enjoy Life', author: 'Jasmine'}
      ]);

  const [selectedPost, setSelectedPost] = useState(null); 
  const [isEditing, setIsEditing] = useState(false);
  const [newTitle, setNewTitle] = useState("");
  const [newAuthor, setNewAuthor] = useState("");
 
  const deletePost = () => {
    if(selectedPost){
      const updatedPosts = posts.filter((post) => post.id !== selectedPost.id);  // Remove the selected post
      setPosts(updatedPosts);
      setSelectedPost(null);  
    }
  }

  const updatePost = () =>{
    if (selectedPost) {
      const updatedPosts = posts.map((post) => {
          if (post.id === selectedPost.id) {
              return { ...post, title: newTitle, author: newAuthor }; 
          }
          return post;
      });
      
      setPosts(updatedPosts);

      //reset
      setSelectedPost(null);  
      setNewTitle(""); 
      setIsEditing(false); 
  }
  }

  return (
    <div>
        <h1>Dashboard</h1>

        {/* Post List */}
        <div style={{display:"flex"}}>
        {posts.map(post => (
                <Post key={post.id} post={post} onClick={() => setSelectedPost(post)}/>
            ))}
        </div>

        {/* Post Detail */}
        {selectedPost && !isEditing && <PostDetails post={selectedPost} onEdit={() => setIsEditing(true)} onDelete={deletePost}/>}

        {/* Edit Post */}
        { selectedPost && isEditing && (
          <div>
              <h3>Edit Post: {selectedPost.id}</h3>
              <input type="text" value={newTitle} onChange={(event) => setNewTitle(event.target.value)} placeholder='new title'/>
              <input type="text" value={newAuthor} onChange={(event) => setNewAuthor(event.target.value)} placeholder='new author'/>
              <button onClick={updatePost}>update</button>
          </div>
        )}
    </div>
  )
}

export default Dashboard