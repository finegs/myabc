const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  devServer: {
//    overlay : false,
  },
  transpileDependencies: true,
  pluginOptions: {
    vuetify: {
      // https://github.com/vuetifyjs/vuetify-loader/tree/next/packages/vuetify-loader
    }
  }
})
