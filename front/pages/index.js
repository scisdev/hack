import React from 'react'
import LayoutHead from "../components/LayoutHead";
import fetch from 'isomorphic-unfetch';
import GoodCard from "../components/GoodCard";


const Home = (props) => (
    <div>
    <LayoutHead />
    <div className="hero">

        <div id="grid">
          {props.goods.map(
              (good, index) => <GoodCard key={index} {...good} />
          )}
        </div>
    </div>


    <style jsx>{`
      .hero {
        width: 100%;
        color: #333;
      }
      #grid {
        display: grid;
        grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
        grid-gap: 2vw;
      }
    `}</style>
  </div>
);

Home.getInitialProps = async function() {
    let data;
    try {
        const res = await fetch('http://localhost:8080/api');
        data = await res.json();
    } catch(error){
        data=[]
    }
    return {
        goods: data
    };
};
export default Home
