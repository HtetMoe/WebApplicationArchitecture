import React, { useState, useLayoutEffect, useRef } from 'react';

//useLayoutEffect demo 
const MeasureDOM = () => {
    const [dimensions, setDimensions] = useState({ width: 0, height: 0 });
    const divRef = useRef();

    // useLayoutEffect to measure DOM size after render, before paint
    useLayoutEffect(() => {
        const rect = divRef.current.getBoundingClientRect();
        setDimensions({ width: rect.width, height: rect.height });
    }, []);

    return (
        <div>
            <div ref={divRef} style={{ width: '200px', height: '150px', backgroundColor: 'lightblue' }}>
                This is a div.
            </div>
            <p>Width: {dimensions.width}px, Height: {dimensions.height}px</p>
        </div>
    );
};

export default MeasureDOM;
