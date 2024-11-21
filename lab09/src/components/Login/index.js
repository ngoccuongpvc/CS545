import { useContext, useRef } from "react";
import { UserContext } from "../../context/UserContext";
import { useNavigate } from "react-router-dom";

export default function Login() {
  const { userData, setUserData } = useContext(UserContext);
  const formRef = useRef();
  const navigate = useNavigate();
  const onLogin = (e) => {
    e.preventDefault();
    console.log(formRef.current["username"]);
    setUserData({
      name: formRef.current["username"].value,
    });
    navigate("/");
  };
  return (
    <div className="container w-25">
      <form ref={formRef} onSubmit={onLogin}>
        <div className="mb-3">
          <label className="form-label">Username</label>
          <input
            type="text"
            className="form-control"
            name="username"
            id="username"
          />
        </div>
        <div className="mb-3">
          <label className="form-label">Password</label>
          <input type="password" className="form-control" name="password" />
        </div>
        <div className="d-flex">
          <div className="mx-auto">
            <button type="submit" className="btn btn-primary">
              Login
            </button>
          </div>
        </div>
      </form>
    </div>
  );
}
