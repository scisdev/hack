import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardHeader from '@material-ui/core/CardHeader';
import CardMedia from '@material-ui/core/CardMedia';
import CardContent from '@material-ui/core/CardContent';
import Typography from '@material-ui/core/Typography';
import { red } from '@material-ui/core/colors';
import AddShoppingCart from '@material-ui/icons/AddShoppingCart';
import CardActions from "@material-ui/core/CardActions";
import IconButton from "@material-ui/core/IconButton";

const useStyles = makeStyles(theme => ({
    card: {
        display: 'flex',
        flexDirection: 'column',
        minWidth: '250px',
        width: '100%'
    },
    media: {
        height: '210px',
        backgroundSize: 'contain'
    },
    expand: {
        transform: 'rotate(0deg)',
        marginLeft: 'auto',
        transition: theme.transitions.create('transform', {
            duration: theme.transitions.duration.shortest,
        }),
    },
    expandOpen: {
        transform: 'rotate(180deg)',
    },
    avatar: {
        backgroundColor: red[500],
    },
    content: {
        flexGrow: 1
    },
}));



const GoodCard = (props) => {
    const classes = useStyles();

    return (
        <Card className={classes.card}>
            
            <CardMedia
                className={classes.media}
                image={`http://chelhack.deletestaging.com/${props.imageUrl}`}
                title="Paella dish"
            />
            <CardHeader

title={props.title}
subheader={<><strike>{props.price}</strike>  {"\t" + props.finalPrice + "\t–"+Math.ceil((1-props.finalPrice/props.price)*100)+"%"}</>} 

/>
            
            <CardActions disableSpacing>
                <IconButton aria-label="add to favorites">
                    <AddShoppingCart />
                </IconButton>
            </CardActions>
        </Card>
    );
};
export default GoodCard;