import React from 'react'
import MovieImage from '../assets/movie_img.png'
import PlayIcon from '../assets/PlayIcon.png'
type MoveDetails={
    movieName:string,
    rating:number,
    imgUrl:string,
    releaseDate:string
}
const MovieCard: React.FC<MoveDetails> = ({movieName, rating, imgUrl, releaseDate}:MoveDetails) => {
  return (
       <div className='m-1 mb-8 hover:cursor-pointer hover:scale-105 duration-300 group/movie relative '>
            <div className="w-full h-[280px] relative  ">
                <div className="img w-full h-full rounded-xl overflow-hidden">
                    <img className='w-full h-full object-fill ' src={MovieImage} alt="movie image" />
                </div>
                <div className='w-18 flex items-center justify-center text-center absolute right-[-18px] top-[-18px] rounded-[50%] bg-primary'>
                     <p className='font-mono w-full p-3 text-center font-extrabold text-xl text-primary-400 '>
                        {
                            rating
                        }
                     </p>

                </div>
                
                <div className="absolute overflow-hidden rounded-b-xl text-pink-300  p-4 flex flex-col justify-between items-center h-[42%] w-full top-[58%] bg-secondary opacity-66">
                      <h2 className='font-bold text-2xl'>{movieName}</h2>
                     <p className='w-full text-center font-nomal text-sm '>
                        relaeasing on {releaseDate}
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