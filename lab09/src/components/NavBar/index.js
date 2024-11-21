import { useContext } from "react";
import { Link } from "react-router-dom";
import { UserContext } from "../../context/UserContext";

export default function NavBar(props) {
  const { userData } = useContext(UserContext);

  return (
    <div className="container">
      <div className="d-flex">
        <div className="mx-auto">
          <Link to={"/posts"}>
            <button className="btn">Posts</button>
          </Link>
          <Link to={"/create-post"}>
            <button className="btn">New Post</button>
          </Link>
        </div>
        <div>
          {userData === null ? (
            <Link to={"/login"}>
              <button className="btn">Log In</button>
            </Link>
          ) : (
            <div>
                <button className="btn">Profile</button>
                <button className="btn">Welcome, {userData.name}</button>
            </div>
          )}
        </div>
      </div>
    </div>
  );
}
