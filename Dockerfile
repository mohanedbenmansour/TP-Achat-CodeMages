FROM nginx:1.13.1-alpine

EXPOSE 80

COPY dist /var/www
COPY config/nginx.conf /etc/nginx/nginx.conf