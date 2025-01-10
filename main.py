from flask import Flask

# Create a Flask app
app = Flask(__name__)

# Route for the homepage
@app.route("/")
def home():
    return "<h1>The Battle of Polytopia</h1><p>Your server is running at 127.0.0.1:5000</p>"

if __name__ == "__main__":
    app.run(debug=True, host="127.0.0.1", port=5000)
