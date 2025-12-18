/** @type {import('tailwindcss').Config} */
export default {
   content: [
    "./src/**/*.{js,jsx,ts,tsx}",
  ],
  theme: {
    extend: {
      color:{
        brand:{
          primary:'#F06269',
          surface:'#870639'
        }
      }
    },
  },
  plugins: [],
}

