#!/bin/bash

echo "📦 Adicionando todos os arquivos..."
git add .

echo "📝 Digite a mensagem do commit:"
read mensagem

git commit -m "$mensagem"

echo "🚀 Enviando para o GitHub..."
git push origin main

echo "✅ Projeto atualizado com sucesso!"
