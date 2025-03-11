import { useState } from "react";
import { FaRegEye } from "react-icons/fa";

export default function Input({type,placeholder,Content,change,contentName,error}){
    const [show, setshow] = useState(false)
    return (
    <div>
    
    <div className={error?"border-red-500 flex px-1 border-2 py-4 rounded-lg m-2":"border-gray-400 flex px-1 border-2 py-4 rounded-lg m-2"} >
        <input  className="placeholder:text-black font-semibold bg-transparent w-full h-full p-1 outline-none"
        type={show?"text":type} placeholder={placeholder} value={Content} onChange={(e)=>{
            change((prev)=>{
                const temp=prev;
                temp[contentName]=e.target.value;
                return temp;
            })
        }}/>
        
        {type=='password'?<button className='p-1' onClick={()=>setshow(!show)}><FaRegEye/></button>:null}
    </div>
    <span className="p-2 text-red-500">{error}</span>
    </div>
    )
}