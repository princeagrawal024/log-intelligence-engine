# Log Intelligence Engine

AI powered log analysis system that performs automated root cause analysis using Large Language Models (LLMs).

The system analyzes application logs and stack traces to automatically detect possible issues, identify root causes, and suggest debugging fixes. It acts as an intelligent debugging assistant for developers and DevOps teams.

---

## Problem

Modern applications generate massive volumes of logs.  
When failures occur, developers must manually inspect logs and stack traces to identify the root cause.

This process is:

• Time consuming  
• Error prone  
• Requires deep debugging expertise  

The Log Intelligence Engine automates this process using AI.

---

## Solution

Log Intelligence Engine analyzes logs and stack traces using an LLM to generate structured root cause analysis.

The system:

• Accepts logs through an API  
• Sends structured prompts to an LLM  
• Receives analysis results  
• Returns root cause and debugging suggestions  

This significantly speeds up debugging and troubleshooting.

---

## Example

Input Logs

java.lang.NullPointerException  
at com.app.UserService.getUser(UserService.java:45)  
at com.app.UserController.getUser(UserController.java:22)

Output

Root Cause  
Null object reference inside UserService.getUser().

Possible Reasons  
• User object returned null from repository  
• Object not initialized before usage  

Suggested Fixes  
• Add null checks  
• Validate repository result  
• Use Optional.orElseThrow()

---

## System Architecture

Client  
↓  
REST API (Spring Boot)  
↓  
Input Validation  
↓  
Prompt Builder  
↓  
LLM Service (Spring AI)  
↓  
LLM Model (OpenAI / Ollama)  
↓  
Root Cause Analysis Response  

---

## Tech Stack

Backend

• Java  
• Spring Boot  
• Spring AI  

AI

• OpenAI API OR Ollama (local LLM)

Caching

• Spring Cache (@Cacheable)

Other Tools

• Maven  
• REST APIs  
• GitHub

---

## API Design

POST /log/analyze

Request

{
 "logs": "java.lang.NullPointerException at UserService.java:45"
}

Response

{
 "rootCause": "Null object reference used in UserService",
 "possibleReasons": [
   "repository returned null",
   "object not initialized"
 ],
 "suggestedFixes": [
   "add null checks",
   "validate repository response"
 ]
}

---

## Key Features

• AI powered log analysis  
• Automated root cause detection  
• Debugging suggestions  
• Prompt controlled AI behavior  
• Cost optimized using caching  

---

## Future Improvements

• Log classification (database, network, memory errors)  
• RAG based knowledge base for known issues  
• Vector search for historical incidents  
• Dashboard for log insights  
• Integration with monitoring systems  

---

## Author

Prince Agrawal

Senior Java Backend Engineer exploring AI enabled backend systems.
