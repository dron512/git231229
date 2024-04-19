export const Header = (props) => {
    console.log(props);
    console.log(props.title);
    return (
        <>
            <h1 className="aa">{props.title}</h1>
        </>
    );
}
export const Header2 = (props) => {
    console.log(props);
    return (
        <>
            <h1 className="aa">{props.key1}</h1>
            <h1 className="aa">{props.value}</h1>
        </>
    );
}
export const Header3 = ({name,value}) => {
    return (
        <>
            <h1 className="aa">제목3</h1>
            <h1 className="aa">{name}</h1>
            <h1 className="aa">{value}</h1>
        </>
    );
}