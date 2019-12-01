import React from 'react'
import Head from 'next/head'

const LayoutHead = ({title}) => {
    return <Head>
    <   title>{title}</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" />
        <link rel="icon" href="/favicon.ico" />
    </Head>
};

export default LayoutHead;