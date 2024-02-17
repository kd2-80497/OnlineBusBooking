// InputForm.jsx
import React, { useState } from 'react';

function InputForm({ onSubmit }) {
  const [source, setSource] = useState('');
  const [destination, setDestination] = useState('');

  const handleSubmit = (event) => {
    event.preventDefault();
    onSubmit({ source, destination });
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Source:
        <input
          type="text"
          value={source}
          onChange={(event) => setSource(event.target.value)}
        />
      </label>
      <br />
      <label>
        Destination:
        <input
          type="text"
          value={destination}
          onChange={(event) => setDestination(event.target.value)}
        />
      </label>
      <br />
      <button type="submit">Submit</button>
    </form>
  );
}

export default InputForm;
