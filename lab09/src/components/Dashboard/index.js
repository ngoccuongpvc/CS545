import { useEffect, useState, useCallback } from "react";
import Posts from "../Posts";
import PostDetails from "../PostDetails";
import AddPost from "../AddPost";
import { PostIdContext } from "../../context/PostIdContext";
import { Outlet } from "react-router-dom";

export default function Dashboard() {
  const [input, setIput] = useState("");

  return (
    <div className="container">
      <Outlet />
    </div>
  );
}
