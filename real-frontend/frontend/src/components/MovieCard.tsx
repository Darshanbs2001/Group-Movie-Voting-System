import React from 'react'
import MovieImage from '../assets/movie_img.png'
type MoveDetails={
    movieName:string,
    rating:number,
    imgUrl:string,
    releaseDate:string
}
const MovieCard: React.FC<MoveDetails> = ({movieName, rating, imgUrl, releaseDate}:MoveDetails) => {
  return (
       <div className='w-fit p-1 '>
            <div className="w-full h-[280px] relative  ">
                <div className="img w-full h-full rounded-xl overflow-hidden">
                    <img className='w-full h-full object-fill ' src={MovieImage} alt="movie image" />
                </div>
                <div className='w-18 flex items-center justify-center text-center absolute right-[-18px] top-[-18px] rounded-[50%] bg-primary'>
                     <p className='font-mono w-full p-3 text-center font-extrabold text-xl text-white opacity-60'>
                        {
                            rating
                        }
                     </p>

                </div>
                
                <div className="absolute overflow-hidden rounded-b-xl text-pink-300  p-4 flex flex-col justify-between items-center h-[35%] w-full top-[65%] bg-secondary opacity-75">
                      <h2 className='font-bold text-2xl'>{movieName}</h2>
                     <p className='w-full text-center font-semibold'>
                        relaeasing on {releaseDate}
                     </p>
                </div>
            </div>
            </div>
        
    
  )
}

export default MovieCard