import React from 'react'
import LayoutHead from "../components/LayoutHead";
import fetch from 'isomorphic-unfetch';
import GoodCard from "../components/GoodCard";

const Home = (props) => (
  <div>
    <LayoutHead />
    <div className="hero">

        <div>
        {props.goods.data.map(
            (good, index) => <GoodCard key={index} {...good} />
        )}
        </div>
    </div>


    <style jsx>{`
      .hero {
        width: 100%;
        color: #333;
      }
    `}</style>
  </div>
);

Home.getInitialProps = async function() {
    const res = await fetch('http://chelhack.deletestaging.com/goods');
    const data = await res.json();

    // console.log(`get Data `, data);

    return {
        goods: data
    };
};
export default Home
