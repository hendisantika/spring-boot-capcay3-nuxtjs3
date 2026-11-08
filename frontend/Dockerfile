# syntax=docker/dockerfile:1

# ---------- Build stage ----------
FROM node:24-alpine AS build
WORKDIR /app

# Use the pnpm version pinned in package.json ("packageManager").
# Corepack is no longer bundled with Node.js 25+, so install it from npm first.
RUN npm install -g corepack@latest && corepack enable

COPY package.json pnpm-lock.yaml ./
RUN --mount=type=cache,id=pnpm,target=/root/.local/share/pnpm/store \
    pnpm install --frozen-lockfile

COPY . .
RUN pnpm build

# ---------- Runtime stage ----------
FROM node:24-alpine
WORKDIR /app

ENV NODE_ENV=production \
    HOST=0.0.0.0 \
    PORT=3000

# Nuxt/Nitro output is self-contained (no node_modules needed)
COPY --from=build --chown=node:node /app/.output ./.output

USER node
EXPOSE 3000

# NUXT_PUBLIC_GOOGLE_RECAPTCHA_KEY is read at runtime (runtimeConfig.public)
CMD ["node", ".output/server/index.mjs"]
