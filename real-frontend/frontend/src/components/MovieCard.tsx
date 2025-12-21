import React from 'react'
import PlayIcon from '../assets/PlayIcon.png'
type MoveDetails={
    id:number,
    movieName?:string,
    rating:string,
    imgUrl:string,
    releaseDate:string
}
const MovieCard: React.FC<MoveDetails> = ({movieName, rating, imgUrl, releaseDate}:MoveDetails) => {
  let displayNames=  new Intl.DisplayNames(["en"],{type:'language'})
   let language =displayNames.of(rating) ;
    return (
       <div className='m-1 mb-8 hover:cursor-pointer hover:scale-105 duration-300 group/movie relative '>
            <div className="w-full h-[280px] relative   ">
                <div className="img w-full h-full rounded-t-xl overflow-hidden text-black">
                 
                    <img className='w-full h-full object-fill ' src={imgUrl} alt={movieName} />
                </div>
                <div className=' flex items-center justify-center text-center absolute left-[-15px] top-0 rounded-sm  bg-primary'>
                     <p className='font-mono w-full p-1 text-center font-bold text-md text-primary-400 '>
                        {
                         language
                        }
                     </p>

                </div>
                
                <div className="absolute overflow-hidden rounded-b-xl text-pink-300  p-1 flex flex-col justify-between items-center h-[20%] w-full bottom-[-20%] bg-secondary opacity-66">
                     <p className='w-full text-center font-bold text-lg '>
                        Releasing On 
                        </p>
                     <p className='w-full text-center font-nomal text-sm '>
                        {releaseDate}
                     </p>
                </div>
                <div className="hidden md:block invisible p-4 flex items-center justify-center  group-hover/movie:visible absolute top-[28%] left-[28%]  bg-primary/40 rounded-[50%]">
                    <img className='w-9 ml-3' src={PlayIcon} alt="play icon" />
                </div>
            </div>
            </div>
        
    
  )
}

export default MovieCard