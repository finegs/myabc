const { defineConfig } = require('@vue/cli-service')
const NodePolyfillPlugin = require("node-polyfill-webpack-plugin");
module.exports = defineConfig({
  devServer: {
//    overlay : false,
  },
  transpileDependencies: true,
  pluginOptions: {
    vuetify: {
      // https://github.com/vuetifyjs/vuetify-loader/tree/next/packages/vuetify-loader
    }
  },
  configureWebpack: {
      plugins: [new NodePolyfillPlugin()],
      optimization: {
        splitChunks: {
          chunks: "all",
        },
      },
    },
})
