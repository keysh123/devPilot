import React from 'react'
import { ThemeProvider } from './components/providers/ThemeProvider'
import { ModeToggle } from './components/ui/mode-toggle'

const App = () => {
  return (
    <ThemeProvider>
    <div>
      <ModeToggle/>
    </div>
    </ThemeProvider>
  )
}

export default App