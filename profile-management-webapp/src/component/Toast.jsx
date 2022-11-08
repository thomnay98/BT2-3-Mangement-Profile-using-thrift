import React, { useEffect } from 'react';
import { toast } from 'react-toastify';
import { useSelector } from "react-redux";

export const Toast = () => {

    const { message } = useSelector(state => state.message);

    useEffect(() => {
        if(message){
            if(message.errC === 0){
                toast.success(message.errM, {
                    position: "top-right",
                    autoClose: 3000,
                    hideProgressBar: false,
                    closeOnClick: true,
                    pauseOnHover: true,
                    draggable: true,
                    progress: undefined,
                    theme: "light",
                  })
            }else{
                toast.error(message.errM, {
                    position: "top-right",
                    autoClose: 3000,
                    hideProgressBar: false,
                    closeOnClick: true,
                    pauseOnHover: true,
                    draggable: true,
                    progress: undefined,
                    theme: "light",
                  })
            }
        }
    }, [message])
    
    return (
        <></>
    )
}
