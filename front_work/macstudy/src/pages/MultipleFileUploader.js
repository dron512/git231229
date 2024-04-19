import axios from "axios";
import React, { useState } from "react";
import { json } from "react-router-dom";

const MultipleFileUploader = () => {
  const [files, setFiles] = useState(null);
  const [status, setStatus] = useState("initial");
  const [imgUrl, setImgUrl] = useState("");

  const handleFileChange = (e) => {
    if (e.target.files) {
      setStatus("initial");
      setFiles(e.target.files);
    }
  };

  const handleUpload = async () => {
    if (files) {
      setStatus("uploading");

      const formData = new FormData();
      [...files].forEach((file) => {
        formData.append("files", file);
      });

      const json = {
        "id": null,
        "name": "file upload success",
        "description": null,
        "price": 0,
        "stock": 0,
        "itemImgDtoList": [{ "imgName": "a.png" }, {}],
      }
      const itemDto = new Blob([JSON.stringify(json)], { type: "application/json" });
      formData.append("itemDto", itemDto);


      try {
        const result = await axios.post('/api/item/new', formData, {
          headers: {
            "Content-Type": "multipart/form-data",
            "Authorization": "Bearer eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJtaFRva2VuIiwiaWQiOjEsInVzZXJuYW1lIjoidGVzdCIsInJvbGUiOiJVU0VSIiwiZW1haWwiOiJhYWFAbmF2ZXIuY29tIiwiZXhwIjoxNzEzNDQxOTE5fQ.Ff8UBe7VLulOORxaULjW6siWT6Z5VZO_zGIn4cLQeFhk7Ak31Dqi-Y-MlJD7QVzc",
          }
        });

        console.log(result.data._links.file.href);
        setStatus("success");

        setImgUrl(result.data._links.file.href);
      } catch (error) {
        console.error(error);
        setStatus("fail");
      }
    }
  };

  return (
    <>
      <div className="input-group">
        <label htmlFor="file" className="sr-only">
          Choose files
        </label>
        <input id="file" type="file" multiple onChange={handleFileChange} />
      </div>
      {files &&
        [...files].map((file, index) => (
          <section key={file.name}>
            File number {index + 1} details:
            <ul>
              <li>Name: {file.name}</li>
              <li>Type: {file.type}</li>
              <li>Size: {file.size} bytes</li>
            </ul>
          </section>
        ))}

        <img src={imgUrl} alt=""/>

      {files && (
        <button onClick={handleUpload} className="submit">
          Upload {files.length > 1 ? "files" : "a file"}
        </button>
      )}

      <Result status={status} />
    </>
  );
};

const Result = ({ status }) => {
  if (status === "success") {
    return <p>✅ Uploaded successfully!</p>;
  } else if (status === "fail") {
    return <p>❌ Upload failed!</p>;
  } else if (status === "uploading") {
    return <p>⏳ Uploading started...</p>;
  } else {
    return null;
  }
};

export default MultipleFileUploader;