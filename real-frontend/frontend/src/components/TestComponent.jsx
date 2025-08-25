
import { useFormik } from 'formik';
import React from 'react'

function TestComponent() {
    function validate(values){
        let errors={};
        if(!values.password){
            errors.password="password cannot be empty";
        }
        return errors;
    }
    const formik =useFormik({
        initialValues:{
            email:'',
            password:''
        },
        validate,
        onSubmit:values=>{
            alert(JSON.stringify(values));
        }
    })
  return (
    <form onSubmit={formik.handleSubmit}>
     <div className='flex justify-between w-[350px]'>
     <label htmlFor="email">Email</label>
     <input type="email" required name="email" className='border-2 m-2' value={formik.values.email} onChange={formik.handleChange} onBlur={formik.handleBlur}/>
     {formik.touched.email && formik.errors.email ? <p>{formik.errors.email}</p>:null}
    </div>
    <div className='flex justify-between w-[350px] overflow-hidden'>
     <label htmlFor="password">Password</label>
     <input type="password" name="password" className='border-2 m-2' value={formik.values.password} onChange={formik.handleChange} onBlur={formik.handleBlur}/>
     {formik.touched.password&& formik.errors.password ? <p>{formik.errors.password}</p>:null}
    </div>
    <button type="submit" className='bg-black text-white py-2 px-4 hover:opacity-50 cursor-pointer rounded'>print</button>
    </form>
  )
}

export default TestComponent