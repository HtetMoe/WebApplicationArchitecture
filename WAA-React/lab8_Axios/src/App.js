import logo from './logo.svg';
import './App.css';
import Dashboard from './Dashboard';
import React from 'react';
import { PostProvider } from './PostContext';

function App() {
  return (
    <PostProvider>
      <Dashboard />
    </PostProvider>
  );
}

export default App;
