import React, { createContext, useState, useContext } from 'react';

// -> to store selected post ID
const PostContext = createContext();

export const usePost = () => useContext(PostContext);

// -> Provider component to wrap the application and provide selectedPost ID globally
export const PostProvider = ({ children }) => {
  const [selectedPostId, setSelectedPostId] = useState(null);

  return (
    <PostContext.Provider value={{ selectedPostId, setSelectedPostId }}>
      {children}
    </PostContext.Provider>
  );
};
