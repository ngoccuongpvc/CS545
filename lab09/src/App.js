import { Navigate, Route, Routes } from "react-router-dom";
import Dashboard from "./components/Dashboard";
import NavBar from "./components/NavBar";
import Posts from "./components/Posts";
import AddPost from "./components/AddPost";
import { UserContextProvider } from "./context/UserContext";
import Login from "./components/Login";

function App() {
  return (
    <div>
      <UserContextProvider>
        <NavBar />
        <Routes>
          <Route path="/login" element={<Login />} />
          <Route path="/" element={<Dashboard />}>
            <Route path="" element={<Navigate to={"/posts"} />} />
            <Route path="posts" element={<Posts />} />
            <Route path="create-post" element={<AddPost />} />
          </Route>
        </Routes>
      </UserContextProvider>
    </div>
  );
}

export default App;
