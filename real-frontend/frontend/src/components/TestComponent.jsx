import { useFormik } from 'formik'
import React from 'react'

function TestComponent() {
    
    const formik =useFormik({
        initialValues:{
            email:'',
            password:''
        },
        validate,
        onSubmit:values=>{
            alert(values);
        }
    })
  return (
    <div>TestComponent</div>
  )
}

export default TestComponent