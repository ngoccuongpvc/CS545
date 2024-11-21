import React, { useState } from "react";



export const UserContext = React.createContext();

export const UserContextProvider = (props) => {

    const [userData, setUserData] = useState(null); 

    return (
        <UserContext.Provider value={{userData, setUserData}}>
            {props.children}
        </UserContext.Provider>
    )
}