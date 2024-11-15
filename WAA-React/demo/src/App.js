import logo from './logo.svg';
import './App.css';
import { useState } from 'react';
import ProductList from './ProductList';
import ReactHookLifeCycle from './Product/ReactHookLifeCycle';
import Counter from './Product/Counter';
import TitleUpdater from './Product/TitleUpdater';
import ThemeProvider from './Product/ThemeContext';
import ThemedComponent from './Product/ThemedComponent';
import Counter1 from './Product/Counter1';
import Counter2 from './Product/Counter2';
import ExpensiveComputation from './Product/ExpensiveComputation'
import UserInput from './Product/UserInput'
import MeasureDOM from './Product/MeasureDOM'
import ComposingComponents from './Product/ComposingComponents';
import RouterDemo from './Routers/RouterDemo';

function App() {

  const [number, setNumber] = useState(0);

  return (
    <div className="App">
      {/* <ProductList/> */}
      {/* <ExampleComponent/> */}
      {/* <Counter initialCount={0}/> */}
      {/* <TitleUpdater/> */}
      {/* <Counter1 /> */}
      {/* <Counter2/> */}

      {/* <ExpensiveComputation number={number} />
      <button onClick={() => setNumber(number + 1)}>Increment</button> */}

      {/* <UserInput/> */}
      {/* <MeasureDOM /> */}
      {/* <ComposingComponents/> */}

      <RouterDemo/>

    </div>

    // <div className='App'>
    //   <ThemeProvider>
    //     <ThemedComponent />
    //   </ThemeProvider>
    // </div>

  );
}

export default App;
