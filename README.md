# Disital-Signature

#### Digital Signature
<summary> 📝 </summary>

$m = hash$(PDF)

  
##### 1. 키 생성 (KeyGen) <br/>
* Alice의 공개키: $A_{pk}$  
* Alice의 개인키: $A_{sk}$
* Bob의 공개키: $B_{pk}$  
* Bod의 개인키: $B_{sk}$

```JAVA
    private static KeyPair generateKeyPair() throws NoSuchAlgorithmException, NoSuchProviderException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "BC");
        keyPairGenerator.initialize(2048, new SecureRandom());
        return keyPairGenerator.generateKeyPair();
    }
```
```JAVA
    private static void saveKeyToFile(Key key, String fileName) throws Exception {
        byte[] keyBytes = key.getEncoded();
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(keyBytes);
        }
    }
```

##### 2. 서명(Sign) <br/>
* 사용한 library: [bouncycastle](https://www.bouncycastle.org/ "보안에서 많이 사용한다함")
* 



</details>

#### TimeStamp
<details>
<summary> ⌚ </summary>









