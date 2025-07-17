import { useState } from 'react';
interface TranslationRequest {
  text: string;
}

interface TranslationResponse {
  translatedText: string;
}

interface ErrorResponse {
  status: number;
  error: string;
  message: string;
  timestamp?: string; // timestamp is optional based on your Java ErrorResponse
}

function App() {
  const [inputText, setInputText] = useState<string>('');
  const [translatedText, setTranslatedText] = useState<string>('');
  const handleTranslate = async () => {
   
  };

  return (
    <div className="App">
      <h1>Georgian to English Translator</h1>
      <div className="input-section">
        <textarea
          placeholder="Enter Georgian text here..."
          value={inputText}
          onChange={(e) => setInputText(e.target.value)}
        ></textarea>
        <button onClick={handleTranslate}>
          Translate
        </button>
      </div>
      <div className="output-section">
        <h2>Translated Text:</h2>
        <p className="translated-text">
          {translatedText || 'No translation yet.'}
        </p>
      </div>
    </div>
  );
}

export default App;