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
        }
      }
    },
  },
  plugins: [],
}

