import numpy as np
import tensorflow as tf 


def testing(img_makanan):
    kelas = ['ampela', 'ayam goreng kentucky', 'ayam panggang', 'bakpia', 'bakso', 'bakwan', 'bayam', 'bebek goreng', 'belimbing', 'bengkuang', 'bihun goreng', 'buah naga', 'bubur ayam', 'bubur ketan hitam', 'durian', 'gado gado', 'getuk singkong', 'gulai ikan', 'gulai kambing', 'ikan lele goreng', 'ikan mujair goreng', 'jagung rebus', 'jambu biji', 'jeruk', 'kangkung rebus', 'keju', 'kentang rebus', 'keripik bayam', 'ketoprak', 'klepon', 'lapis legit', 'makaroni', 'mie ayam', 'mie goreng', 'nasi goreng', 'nasi jagung', 'nasi putih', 'onde onde', 'pempek telur', 'pisang', 'rawon', 'singkong rebus', 'tahu', 'telur dadar', 'telur rebus']
    nameOfFile = "train_makanan_10_epoch.h5"
    
    
 #   trained_model = tf.keras.models.load_model(nameOfFile)
    
    load_trained_model = tf.keras.models.load_model("train_makanan_10_epoch.h5")
        
    img_makanan = img_makanan.resize((200,200))
    
    
    img_makanan = np.expand_dims(img_makanan,axis=0)
    
    prediction = load_trained_model.predict(img_makanan)
    
    
    
    list_index = [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44]
    x = prediction
    for i in range(45):
        for j in range(45):
            if x[0][list_index[i]] > x[0][list_index[j]]:
                temp = list_index[i]
                list_index[i] = list_index[j]
                list_index[j] = temp
                
    
    hasil_klasifikasi=''
    i=0
    for i in range(1):
        hasil_klasifikasi = kelas[list_index[i]]
        
      
    return hasil_klasifikasi


def test():
    return "Hello world Chaquopy"
    