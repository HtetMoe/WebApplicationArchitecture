import axios from "axios";
import React from "react";
import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import Post from './Post'

function Posts() {
    const [posts, setPosts] = useState([])

    useEffect(() => {
        axios.get('http://localhost:8080/api/v1/posts')
            .then(response => setPosts(response.data))
            .catch(error => console.error("Error fetching posts:", error));
    }, []);

    return (
        <div>
            <h3>Posts</h3>
            <div style={{ display: "flex" }}>
                {posts.map(post => (
                    <div key={post.id} style={{ margin: '10px' }}>
                        <Link to={`/posts/${post.id}`} style={{ textDecoration: 'none' }}>
                            <Post post={post} />
                        </Link>
                    </div>

                ))}
            </div>

        </div>
    )
}
export default Posts