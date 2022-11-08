import { api } from "./api"


export const register = (newUser) => {
  return api.post('/api-register', newUser)
  }
  
export const login = (user) => {
  return api.post("/api-login", user)
}

export const logout = () => {
  return api.post("/api-logout")
}

export const firstAccess = () => {
  return api.get("/api-first-access")
}