import React from "react";

const Post = ({post, onClick}) => {
    return(
        <div onClick={onClick} style={{border: "1px solid #ccc", margin: "10px", padding:"10px"}}>
        <p>ID : {post.id}</p>
        <p>Title : {post.title}</p>
        <p>Author : {post.author}</p>
        </div>
    )
}

export default Post