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
  

  return (
   <></>
  );
}

export default App;