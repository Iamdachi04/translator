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
    //აქ შემოგვყავს ტექსტი , რომელიც უნდა ითარგმნოს
    const requestBody: TranslationRequest = { text: inputText };
    //აქ ვაკეთებთ თხოვნას სერვერზე, რომ ტექსტი ითარგმნოს , და პასუხსაც აქ ვინახავთ , ამ რესპონსში
    const response = await fetch('http://localhost:8080/api/translate', {
      //აქ ვაყენებთ მეთოდს პოსტი, რადგან ჩვენ ვგზავნით მონაცემებს სერვერზე და
      // ვაყენებთ ჰედერებს, რომ სერვერმა იცოდეს, რომ ჩვენ ჯეისონის მონაცემებს ვგზავნით
      method: 'POST',
      
      headers: {
        'Content-Type': 'application/json',
      },
      //აქ ვგზავნით მონაცემებს სერვერზე, რომ ტექსტი ითარგმნოს  , ანუ თითონ ტექსტს ვწერთ აქ.
      body: JSON.stringify(requestBody),
    });
    if (!response.ok) {
      const errorData: ErrorResponse = await response.json();
      throw new Error(errorData.message || `HTTP error! status: ${response.status}`);
    }
    // თუ ყველაფერი კარგადაა, ვიღებთ პასუხს    
    const data: TranslationResponse = await response.json();
    // და ვაყენებთ ამ პასუხს სტეიტში, რომ ჩვენ შეგვიძლია გამოვიყენოთ ეს ტექსტი
    setTranslatedText(data.translatedText);
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