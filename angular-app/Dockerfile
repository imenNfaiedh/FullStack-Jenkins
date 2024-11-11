
# Étape 1 : Construire l'application Angular
FROM node:16 AS build

# Définir le répertoire de travail
WORKDIR /app

# Copier les fichiers package.json et package-lock.json
COPY package*.json ./

# Installer les dépendances
RUN npm install

# Copier tous les fichiers du projet
COPY . .

# Construire l'application Angular (produit optimisé pour la production)
RUN npm run build --prod

# Étape 2 : Servir l'application avec Nginx
FROM nginx:alpine

# Copier les fichiers construits depuis l'étape précédente vers le répertoire public de Nginx
COPY --from=build /app/dist/angular-app /usr/share/nginx/html

# Exposer le port sur lequel Nginx va écouter
EXPOSE 80

# Lancer Nginx en mode de foreground
CMD ["nginx", "-g", "daemon off;"]
