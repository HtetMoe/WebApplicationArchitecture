import React, { useState, useMemo } from 'react';

function ExpensiveComputation({ number }) {

    const computeFactorial = (num) => {
        console.log('num! ', num);
        return num === 0 ? 1 : num * computeFactorial(num - 1);
    };

    // will be recalculated every time the component re-renders, even if number hasn't changed
    // const factorial = computeFactorial(number);

    // Memoize the result to avoid recomputing unless `number` changes
    const factorial = useMemo(() => computeFactorial(number),
        [number]
    );

    return (
        <div>
            <p>Factorial of {number}: {factorial}</p>
        </div>
    );
};

export default ExpensiveComputation