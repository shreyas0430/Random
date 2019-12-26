import cv2

t = 0
camera = cv2.VideoCapture(0)

while(True):
    _, frame = camera.read()
    frame = cv2.flip(frame, 1)
    k = cv2.waitKey(1)
    cv2.imshow('Camera',frame)

    if k==ord('s'):
        cv2.imwrite('captured' + str(t) + '.png',frame)
        t+=1
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

cap.release()
cv2.destroyAllWindows()
