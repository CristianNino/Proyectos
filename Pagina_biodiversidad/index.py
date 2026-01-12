from flask import Flask, render_template

aplicacion = Flask(__name__)

@aplicacion.route('/')
def index():
    return render_template('Index.html')

@aplicacion.route('/informacion')
def informacion():
    return render_template('Informacion.html')

@aplicacion.route('/flora')
def flora():
    return render_template('Flora.html')

@aplicacion.route('/fauna')
def fauna():
    return render_template('Fauna.html')

if __name__ == '__main__':
    aplicacion.run(debug = True)