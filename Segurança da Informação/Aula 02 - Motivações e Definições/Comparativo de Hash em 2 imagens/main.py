# Python program to find MD5 hash value of a file
import hashlib

arquivos = ["ship.jpeg", "plane.jpeg"]

for arquivo in arquivos:
  with open(arquivo,"rb") as f:
    bytes = f.read() # read file as bytes
    readable_hash = hashlib.md5(bytes).hexdigest();
    print(arquivo + ": " + readable_hash)

for arquivo in arquivos:
  with open(arquivo,"rb") as f:
    bytes = f.read() # read file as bytes
    readable_hash = hashlib.sha256(bytes).hexdigest();
    print(arquivo + ": " + readable_hash)
