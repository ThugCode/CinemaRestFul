module.exports = {
  module: {
    preLoaders: [
      {
        test: /\.ts$/,
        exclude: /node_modules/,
        loader: 'tslint'
      }
    ],

    loaders: [
      {
        test: /.json$/,
        loaders: [
          'json'
        ]
      },
      {
        test: /\.ts$/,
        exclude: /node_modules/,
        loaders: [
          'ts'
        ]
      },
      {
        test: /.html$/,
        loaders: [
          'html'
        ]
      },
      {
        test: /\.(woff|woff2)$/,
        loader: 'url-loader?limit=10000&mimetype=application/font-woff'
      },
      {
        test: /\.ttf$/,
        loader: 'file-loader'
      },
      {
        test: /\.eot$/,
        loader: 'file-loader'
      },
      {
        test: /\.svg$/,
        loader: 'file-loader'
      }
    ]
  },
  plugins: [],
  debug: true,
  devtool: 'cheap-module-eval-source-map',
  resolve: {
    extensions: [
      '',
      '.webpack.js',
      '.web.js',
      '.js',
      '.ts'
    ]
  },
  ts: {
    configFileName: 'conf/ts.conf.json'
  },
  tslint: {
    configuration: require('../tslint.json')
  }
};
