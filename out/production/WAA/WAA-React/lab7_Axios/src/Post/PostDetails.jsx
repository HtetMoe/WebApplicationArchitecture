import React from 'react'

const PostDetails = ({post, onEdit, onDelete}) => {
  return (
    <div style={{margin: "10px", padding:"10px"}}>
        <h3>PostDetails</h3>
        <p>Title : {post.title} </p>
        <p>Title : {post.author} </p>
        <button onClick={onEdit}  style={{ marginRight: "10px" }}>Edit</button>
        <button onClick={onDelete}>Delete</button>
    </div>
  )
}

export default PostDetails