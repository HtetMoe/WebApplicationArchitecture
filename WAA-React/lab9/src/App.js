import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Posts from './components/Posts';
import { PostDetails } from './components/PostDetails';
import { AddOrEditPost } from './components/AddOrEditPost';
import Layout from './components/Layout';
import { Login } from './components/Login';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route path='/posts' element={<Posts />} />
          <Route path="/posts/:id" element={<PostDetails />} />
          <Route path="/add" element={<AddOrEditPost />} />
          <Route path="/edit/:id" element={<AddOrEditPost />} />
          <Route path='/signin' element={<Login />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
