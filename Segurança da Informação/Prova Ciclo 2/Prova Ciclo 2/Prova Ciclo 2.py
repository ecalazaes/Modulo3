import cv2
import numpy as np
import os

# Função para extrair descritores de uma imagem
def extract_descriptors_from_image(image_path):
    image = cv2.imread(image_path, cv2.IMREAD_GRAYSCALE)
    if image is None:
        print(f"Não foi possível carregar a imagem: {image_path}")
        return None, None

    sift = cv2.SIFT_create()
    keypoints, descriptors = sift.detectAndCompute(image, None)

    return keypoints, descriptors

# Função para carregar descritores de um arquivo .txt
def load_descriptors_from_txt(txt_path):
    return np.loadtxt(txt_path, dtype=np.float32)

# Setar o caminho do arquivo .txt de teste aqui (caminho relativo ao script)
test_descriptor_path = "database/file8.txt"
test_descriptors = load_descriptors_from_txt(test_descriptor_path)

# Inicializar a lista de pontos de correspondência
match_points = []

# Setar o caminho do diretório da base de dados aqui (caminho relativo ao script)
database_dir = "database/database4/"

# Variável para armazenar a imagem de banco de dados correspondente
best_match_image = None
best_match_file = None

for file in os.listdir(database_dir):
    if file.endswith(".tif"):
        fingerprint_database_image_path = os.path.join(database_dir, file)
        fingerprint_database_image = cv2.imread(fingerprint_database_image_path, cv2.IMREAD_GRAYSCALE)

        if fingerprint_database_image is None:
            print(f"Não foi possível carregar a imagem: {fingerprint_database_image_path}")
            continue

        # Extrair descritores da imagem da base de dados
        db_keypoints, db_descriptors = extract_descriptors_from_image(fingerprint_database_image_path)
        if db_descriptors is None:
            continue

        # Comparar os descritores usando FLANN
        flann = cv2.FlannBasedMatcher(dict(algorithm=1, trees=5), dict(checks=50))
        matches = flann.knnMatch(test_descriptors, db_descriptors, k=2)

        # Aplicar ratio test
        good_matches = []
        for p, q in matches:
            if p.distance < 0.1 * q.distance:
                good_matches.append(p)

        # Verificar se há uma correspondência significativa
        if len(good_matches) / len(test_descriptors) > 0:
            match_points.extend(good_matches)
            best_match_image = fingerprint_database_image
            best_match_file = file
            break

if best_match_image is not None:
    keypoints = len(test_descriptors)
    print(f"Número de keypoints: {keypoints}")
    print(f"Número de pontos correspondentes: {len(match_points)}")
    print(f"% match: {len(match_points) / keypoints * 100}")
    print(f"Fingerprint ID: {best_match_file}")

    # Desenhar correspondências na imagem
    result = cv2.drawMatches(best_match_image, db_keypoints, best_match_image, db_keypoints, match_points, None)
    result = cv2.resize(result, None, fx=1.5, fy=1.5)
    cv2.imshow("Matching Result", result)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

else:
    print("Nenhuma correspondência significativa encontrada.")
